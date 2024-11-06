package com.example.mtg.service;

import com.example.mtg.model.Library;
import com.example.mtg.model.User;
import com.example.mtg.repository.repositoryInterfaces.LibraryRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    UserService userService;

    public Result<List<Library>> findAllLibrariesByUser(String userid) {
        Result<List<Library>> result = new Result<>();
        result.setPayload(libraryRepository.findAllLibrariesByUser(userid));

        if(result.getPayload().size() <= 0){
            result.addMessage("No libraries found by given user " + userid, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Library> findLibraryByName(String libraryName, String userid) {
        Result<Library> result = new Result<>();
        result.setPayload(libraryRepository.findLibraryByName(libraryName, userid));

        if(result.getPayload() == null){
            result.addMessage("No library found by given name " + libraryName + " and user " + userid,
                    ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Library> add(Library library) {
        Result<Library> result = new Result<>();
        result.setPayload(library);
        Result<User> user = userService.findById(library.getUserId());

        if (!validateLibraryName(library.getLibraryName())){
            result.addMessage("The provided library name " + library.getLibraryName() + " is invalid. Library " +
                    "names must be between 2 to 25 characters and may only contain alphanumeric characters and spaces",
                    ResultType.INVALID);
        } else if (libraryRepository.findLibraryByName(library.getLibraryName(), library.getUserId()) != null) {
            result.addMessage("The provided library name " + library.getLibraryName() + " is already in use",
                    ResultType.ERROR);
        } else if (user == null) {
            result.addMessage("The provided userId " + library.getUserId() + " associated with the provided library is "
                            + ResultType.NOT_FOUND.label, ResultType.NOT_FOUND);
        } else {
            libraryRepository.add(library);
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Boolean> update(Library library) {
        Result<Boolean> result = new Result<>();
        result.setPayload(false);

        Library library1 = libraryRepository.findLibraryByName(library.getLibraryName(), library.getUserId());

        if (!validateLibraryName(library.getLibraryName())){
            result.addMessage("The provided library name " + library.getLibraryName() + " is invalid. Library " +
                            "names must be between 2 to 25 characters and may only contain alphanumeric characters and spaces",
                    ResultType.INVALID);
        } else if (library1 != null && (library.getLibraryId() != library1.getLibraryId())){
            result.addMessage("The provided library name " + library.getLibraryName() +
                    " is already in use", ResultType.ERROR);
        } else if (!libraryRepository.update(library)){
            result.addMessage("Failed to update library " + library.getLibraryId() + " associated with user "
                    + library.getUserId(), ResultType.ERROR);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            result.setPayload(true);
        }
        return result;
    }

    public Result<Boolean> delete(Library library) {
        Result<Boolean> result = new Result<>();
        result.setPayload(false);

        if (!validateLibraryName(library.getLibraryName())) {
            result.addMessage("The provided library name " + library.getLibraryName() + " is invalid. Library " +
                            "names must be between 2 to 25 characters and may only contain alphanumeric characters and spaces",
                    ResultType.INVALID);
        } else if (libraryRepository.findLibraryByName(library.getLibraryName(), library.getUserId()) == null) {
            result.addMessage("The provided library " + library.getLibraryName() + " is " + ResultType.NOT_FOUND.label,
                    ResultType.NOT_FOUND);
        } else if (userService.findById(library.getUserId()) == null) {
            result.addMessage("User " + library.getUserId() + " associated with the provided library is "
                    + ResultType.NOT_FOUND.label, ResultType.NOT_FOUND);
        } else if (!libraryRepository.delete(library)) {
            result.addMessage("Failed to delete provided library " + library.getLibraryId() + " "
                    + library.getLibraryName(), ResultType.ERROR);
        } else {
            result.setPayload(true);
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public boolean validateLibrary(Library library) {
        return validateLibraryName(library.getLibraryName());
    }

    private boolean validateLibraryName(String libraryName) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]{2,25}$");
        Matcher matcher = pattern.matcher(libraryName);
        return matcher.matches();
    }
}
