package com.scart.ProfileService.Service;

import com.scart.ProfileService.Model.Profile;
import com.scart.ProfileService.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    ProfileRepository repository;

    @Override
    public Profile addNewCustomerProfile(Profile user) {
        user.setProfileId(sequenceGeneratorService.getSequenceNumber(Profile.SEQUENCE_NAME));
        return repository.save(user);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public Optional<Profile> getByProfileId(int profileId) {
        Optional<Profile> user = repository.findById(profileId);
        return user;
    }

    @Override
    public Profile updateProfile(Profile user, int profileId) {
        Profile prof= repository.findById(profileId).get();
        prof.setFullName(user.getFullName());
        prof.setGender(user.getGender());
        prof.setEmailId(user.getEmailId());
        prof.setMobileNumber(user.getMobileNumber());
        return repository.save(prof);

    }

    @Override
    public void deleteProfileById(int profileId) {
        repository.deleteById(profileId);
    }

    @Override
    public Optional<Profile> profileByEmail(String emailId) {
        return repository.findByEmail(emailId);
    }

//    @Override
//    public Optional<Profile> profileByMail(String emailId) {
//        //Optional<Profile> profile = repository.findByEmail(emailId);
//        return repository.findByEmail(emailId);
    }

