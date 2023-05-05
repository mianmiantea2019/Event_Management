/**
 * @author: Christy Guo
 * @create_date: 2023-05-04 11:19 PM
 * @desc:
 * @modifier:
 */

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AuthData {
    private Integer userId;
    private String token;
    private Integer tokenExpiration;
}
