package codesquad.springcafe.repository.user;

import codesquad.springcafe.dto.UpdatedUser;
import codesquad.springcafe.dto.User;
import java.util.List;

public interface UserRepository {
    User addUser(User user);

    User findUserByUserId(String userId) throws Exception;

    String updateUser(String userId, UpdatedUser updatedUser) throws Exception;

    String deleteUser(String userId);

    List<User> findAllUser();
}