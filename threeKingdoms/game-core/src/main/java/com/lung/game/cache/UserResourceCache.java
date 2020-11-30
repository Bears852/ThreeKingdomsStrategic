package com.lung.game.cache;

import com.lung.game.domain.user.UserResource;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/6 - 18:43
 * @implSpec
 */
@Repository
public interface UserResourceCache extends KeyValueRepository<UserResource, Long> {

}
