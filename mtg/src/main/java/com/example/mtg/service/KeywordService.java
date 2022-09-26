package com.example.mtg.service;

import com.example.mtg.model.Keyword;
import com.example.mtg.repository.repositoryInterfaces.KeywordRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class KeywordService {
    @Autowired
    private KeywordRepository repository;

    public Result<List<Keyword>> findAllKeywords() {
        Result<List<Keyword>> result = new Result<>();
        result.setPayload(repository.findAllKeywords());

        if(result.getPayload().size() <= 0){
            result.addMessage("No keywords found", ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Keyword> findKeywordById(int keywordId) {
        Result<Keyword> result = new Result<>();
        result.setPayload(repository.findKeywordById(keywordId));

        if(result.getPayload() == null){
            result.addMessage("No keyword found by given id " + keywordId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Keyword> findKeywordByName(String keywordName) {
        Result<Keyword> result = new Result<>();
        result.setPayload(repository.findKeywordByName(keywordName));

        if(result.getPayload() == null){
            result.addMessage("No keyword found by given name " + keywordName, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Keyword> add(Keyword keyword) {
        Result<Keyword> result = new Result<>();
        result.setPayload(repository.add(keyword));

        if(!validateKeywordName(keyword.getKeywordName())) {
            result.addMessage("The provided keyword name " + keyword.getKeywordName() + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (repository.findKeywordByName(keyword.getKeywordName()) != null) {
            result.addMessage("The provided keyword name " + keyword.getKeywordName() + " is already in use",
                    ResultType.INVALID);
        } else {
            result.addMessage("success", ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Boolean> update(Keyword keyword) {
        Result<Boolean> result = new Result<>();
        result.setPayload(false);

        if(!validateKeywordName(keyword.getKeywordName())) {
            result.addMessage("The provided keyword name " + keyword.getKeywordName() + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (repository.findKeywordByName(keyword.getKeywordName()) == null) {
            result.addMessage("The provided keyword " + keyword.getKeywordName() + " is not found",
                    ResultType.NOT_FOUND);
        } else {
            result.setPayload(repository.update(keyword));
            result.addMessage("success", ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Boolean> delete(Keyword keyword) {
        Result<Boolean> result = new Result<>();
        result.setPayload(false);

        if(!validateKeywordName(keyword.getKeywordName())) {
            result.addMessage("The provided keyword name " + keyword.getKeywordName() + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (repository.findKeywordByName(keyword.getKeywordName()) == null) {
            result.addMessage("The provided keyword " + keyword.getKeywordName() + " is not found",
                    ResultType.NOT_FOUND);
        } else {
            if(repository.delete(keyword)) {
                result.setPayload(true);
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            } else {
                result.addMessage("Failed to delete given keyword " + keyword.getKeywordName(), ResultType.ERROR);
            }
        }
        return result;
    }

    private boolean validateKeywordName(String KeywordName) {
        Pattern pattern = Pattern.compile("^[a-zA-Z ]{2,25}$");
        Matcher matcher = pattern.matcher(KeywordName);
        return matcher.matches();
    }
}
