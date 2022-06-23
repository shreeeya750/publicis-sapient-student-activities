package com.example.controller;

import com.example.exceptions.ProfileNotFoundException;
import com.example.model.beans.Friend;
import com.example.model.beans.Profile;
import com.example.model.service.FriendService;
import com.example.model.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private FriendService friendService;

    @PostMapping
    public ResponseEntity<Object> store (@RequestBody Profile profile) {
        Profile storedProfile = profileService.storeProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(storedProfile);
    }

    @GetMapping
    public ResponseEntity<Object> getProfile() {
        List<Profile> list = profileService.fetchProfile();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfile(@PathVariable("id") int id) {
        try {
            Profile profile = profileService.fetchProfile(id);
            return ResponseEntity.status(HttpStatus.OK).body(profile);
        }
        catch (ProfileNotFoundException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("error", e.getMessage());
            map.put("status", "404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }

    @PostMapping("/{profileId}")
    public ResponseEntity<Object> addFriend(@RequestBody Friend friend, @PathVariable("profileId") int id) {
        Friend createdFriend = friendService.addFriend(id, friend);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", "Added " + createdFriend.getName());
        map.put("description", "Added to profile id: " + createdFriend.getProfileIdRef());
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
