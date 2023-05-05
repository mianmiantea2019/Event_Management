
/**
 * @author: Christy Guo
 * @create_date: 2023-05-04 11:19 PM
 * @desc:
 * @modifier:
 */



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netflix.graphql.dgs.*;
import com.netflix.graphql.dgs.context.DgsContext;
import com.spring2go.easyevent.custom.AuthContext;
import com.spring2go.easyevent.entity.BookingEntity;
import com.spring2go.easyevent.entity.EventEntity;
import com.spring2go.easyevent.entity.UserEntity;
import com.spring2go.easyevent.mapper.BookingEntityMapper;
import com.spring2go.easyevent.mapper.EventEntityMapper;
import com.spring2go.easyevent.mapper.UserEntityMapper;
import com.spring2go.easyevent.type.Booking;
import com.spring2go.easyevent.type.Event;
import com.spring2go.easyevent.type.User;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@DgsComponent
@RequiredArgsConstructor
public class BookingDataFetcher {
    private final BookingEntityMapper bookingEntityMapper;
    private final EventEntityMapper eventEntityMapper;
    private final UserEntityMapper userEntityMapper;

    @DgsQuery
    public List<Booking> bookings(DataFetchingEnvironment dfe) {
        AuthContext authContext = DgsContext.getCustomContext(dfe);
        authContext.ensureAuthenticated();

        QueryWrapper<BookingEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BookingEntity::getUserId, authContext.getUserEntity().getId());
        List<Booking> bookings = bookingEntityMapper.selectList(queryWrapper)
                .stream()
                .map(Booking::fromEntity)
                .collect(Collectors.toList());
        return bookings;
    }

    @DgsMutation
    public Event cancelBooking(@InputArgument(name = "bookingId") String bookingIdString,
                               DataFetchingEnvironment dfe) {
        AuthContext authContext = DgsContext.getCustomContext(dfe);
        authContext.ensureAuthenticated();

        Integer bookingId = Integer.parseInt(bookingIdString);

        BookingEntity bookingEntity = bookingEntityMapper.selectById(bookingId);
        if (bookingEntity == null) {
            throw new RuntimeException(String.format("Booking with id %s does not exist", bookingIdString));
        }

        Integer userId = bookingEntity.getUserId();
        UserEntity userEntity = authContext.getUserEntity();
        if (!userEntity.getId().equals(userId)) {
            throw new RuntimeException("You are not allowed to cancel other people's booking!");
        }

        bookingEntityMapper.deleteById(bookingId);

        Integer eventId = bookingEntity.getEventId();
        EventEntity eventEntity = eventEntityMapper.selectById(eventId);
        Event event = Event.fromEntity(eventEntity);
        return event;
    }

}
