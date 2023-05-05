/*
 * @Author: mianmiantea2019
 * @Date: 2023-05-04 23:52:58
 * @LastEditors: mianmiantea2019
 * @LastEditTime: 2023-05-04 23:53:01
 * @Description: 
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
