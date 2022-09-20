package com.scart.ProfileService.Controller;

import com.scart.ProfileService.Model.Profile;
import com.scart.ProfileService.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService service;

    @PostMapping("/save")
    public Profile addNewCustomerProfile(@RequestBody Profile user) {
        return service.addNewCustomerProfile(user);
    }

    @GetMapping("/show")
    public List<Profile> getAllProfiles() {
        return service.getAllProfiles();
    }

    @PutMapping("update/{id}")
    public Profile updateProfile(@RequestBody Profile user, @PathVariable("id") int profileId) {
        return service.updateProfile(user, profileId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable("id") int profileId) {
        service.deleteProfileById(profileId);
    }

    @GetMapping("/getbymail/{emailId}")
    public Optional<Profile> profileByEmail(@PathVariable String emailId) {
        return service.profileByEmail(emailId);
    }
}
