package com.example.mtg.service;

import com.example.mtg.model.Expansion;
import com.example.mtg.repository.jdbcRepositories.ExpansionJdbcRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ExpansionService {
    @Autowired
    private ExpansionJdbcRepository repository;

    public Result<List<Expansion>> findAllExpansions() {
        Result<List<Expansion>> result = new Result<>();
        result.setPayload(repository.findAllExpansions());
        if(result.getPayload() == null) {
            result.addMessage("No expansions found", ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Expansion> findExpansionById(int expansionId) {
        Result<Expansion> result = new Result<>();
        result.setPayload(repository.findExpansionById(expansionId));
        if(result.getPayload() == null) {
            result.addMessage("No expansion found by given id " + expansionId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Expansion> findExpansionByName(String expansionName) {
        Result<Expansion> result = new Result<>();
        result.setPayload(repository.findExpansionByName(expansionName));
        if(result.getPayload() == null) {
            result.addMessage("No expansion found by given name " + expansionName, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Expansion> findExpansionByCode(String expansionCode) {
        Result<Expansion> result = new Result<>();
        result.setPayload(repository.findExpansionByCode(expansionCode));
        if(result.getPayload() == null) {
            result.addMessage("No expansion found by given code " + expansionCode, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Expansion> add(Expansion expansion) {
        Result<Expansion> result = new Result<>();

        if(!validateExpansionName(expansion.getExpansionName())){
            result.addMessage("The given expansion name " + expansion.getExpansionName() + " is invalid",
                    ResultType.INVALID);
        } else if (repository.findExpansionByName(expansion.getExpansionName()) != null) {
            result.addMessage("The given expansion name " + expansion.getExpansionName() + " is already in use",
                    ResultType.INVALID);
        } else if (!validateExpansionCode(expansion.getExpansionCode())){
            result.addMessage("The given expansion code " + expansion.getExpansionCode() + " is invalid",
                    ResultType.INVALID);
        } else if (repository.findExpansionByCode(expansion.getExpansionCode()) != null) {
            result.addMessage("The given expansion code " + expansion.getExpansionCode() + " is already in use",
                    ResultType.INVALID);
        } else if (!validateExpansionReleasedDate(expansion.getReleasedDate())) {
            result.addMessage("The given expansion release date " + expansion.getReleasedDate() + " is invalid",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.add(expansion));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given expansion " + expansion, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public Result<Boolean> update(Expansion expansion) {
        Result<Boolean> result = new Result<>();

        if(!validateExpansionName(expansion.getExpansionName())){
            result.addMessage("The given expansion name " + expansion.getExpansionName() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateExpansionCode(expansion.getExpansionCode())){
            result.addMessage("The given expansion code " + expansion.getExpansionCode() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateExpansionReleasedDate(expansion.getReleasedDate())) {
            result.addMessage("The given expansion release date " + expansion.getReleasedDate() + " is invalid",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.update(expansion));
            if(!result.getPayload()) {
                result.addMessage("Failed to update given expansion " + expansion, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public Result<Boolean> delete(Expansion expansion) {
        Result<Boolean> result = new Result<>();
        if(repository.findExpansionById(expansion.getExpansionId()) == null){
            result.addMessage("The given expansion " + expansion.getReleasedDate() + " is not found",
                    ResultType.NOT_FOUND);
        } else {
            result.setPayload(repository.delete(expansion));
            if(!result.getPayload()) {
                result.addMessage("Failed to update given expansion " + expansion, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    private boolean validateExpansionName(String expansionName) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\d\\s:]*$");
        Matcher matcher = pattern.matcher(expansionName);
        return matcher.matches();
    }

    private boolean validateExpansionCode(String expansionCode) {
        Pattern pattern = Pattern.compile("^[A-Z]{3}$");
        Matcher matcher = pattern.matcher(expansionCode);
        return matcher.matches();
    }

    private boolean validateExpansionReleasedDate(Date date) {
        return date.after(Date.valueOf("1993-08-01")) && date.before(Date.valueOf(LocalDate.now().plusYears(2)));
    }

}
