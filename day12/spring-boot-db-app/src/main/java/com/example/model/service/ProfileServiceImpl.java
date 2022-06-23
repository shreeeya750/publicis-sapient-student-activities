package com.example.model.service;

import com.example.exceptions.ProfileNotFoundException;
import com.example.model.beans.Friend;
import com.example.model.beans.Profile;
import com.example.model.dao.FriendRepository;
import com.example.model.dao.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileDao;

    @Autowired
    private FriendRepository friendDao;

    @Transactional
    @Override
    public Profile storeProfile(Profile profile) {
        Profile createdProfile = profileDao.save(profile);
        return createdProfile;
    }

    @Override
    public List<Profile> fetchProfile() {
        List<Profile> list = profileDao.findAll();
        return list;
    }

    @Override
    public Profile fetchProfile(int id) throws ProfileNotFoundException {
        Profile profile = profileDao.findById(id).orElse(null);
        if (profile == null) {
            throw new ProfileNotFoundException("Profile with an id: " + id + " is not found!");
        }
        List<Friend> friends = friendDao.getFriendsFromProfile(id);
        profile.setFriends(friends);
        return profile;
    }
}
