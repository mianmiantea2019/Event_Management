/*
 * @Author: mianmiantea2019
 * @Date: 2023-05-04 23:52:58
 * @LastEditors: mianmiantea2019
 * @LastEditTime: 2023-05-04 23:53:01
 * @Description: 
 */


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