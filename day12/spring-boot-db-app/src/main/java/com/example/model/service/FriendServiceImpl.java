package com.example.model.service;

import com.example.model.beans.Friend;
import com.example.model.dao.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendDao;

    @Override
    @Transactional
    public Friend addFriend(int profileIdRef, Friend friend) {
        friend.setProfileIdRef(profileIdRef);
        return friendDao.save(friend);
    }
}
