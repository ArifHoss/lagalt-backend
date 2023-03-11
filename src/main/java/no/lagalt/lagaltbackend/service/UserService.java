package no.lagalt.lagaltbackend.service;

import no.lagalt.lagaltbackend.pojo.entity.AppUser;

public interface UserService extends CrudService<AppUser,Integer>{
    AppUser getByUsername(String username);

    AppUser getCurrentTokenUser();
}
