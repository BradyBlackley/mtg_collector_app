package com.example.mtg.service;

import com.example.mtg.model.Type;
import com.example.mtg.repository.repositoryInterfaces.TypeRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public Result<List<Type>> findAllTypes() {
        Result<List<Type>> result = new Result<>();
        result.setPayload(repository.findAllTypes());

        if(result.getPayload().size() <= 0){
            result.addMessage("No types found", ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Type> findTypeByName(String typeName) {
        Result<Type> result = new Result<>();
        result.setPayload(repository.findTypeByName(typeName));

        if(result.getPayload() == null){
            result.addMessage("No type found by given name " + typeName, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Type> add(Type type) {
        Result<Type> result = new Result<>();
        result.setPayload(repository.add(type));

        if(!validateTypeName(type.getTypeName())) {
            result.addMessage("The provided type name " + type.getTypeName() + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (repository.findTypeByName(type.getTypeName()) != null) {
            result.addMessage("The provided type name " + type.getTypeName() + " is already in use",
                    ResultType.INVALID);
        } else {
            result.addMessage("success", ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Boolean> update(Type type) {
        Result<Boolean> result = new Result<>();
        result.setPayload(false);

        if(!validateTypeName(type.getTypeName())) {
            result.addMessage("The provided type name " + type.getTypeName() + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (repository.findTypeByName(type.getTypeName()) == null) {
            result.addMessage("The provided type " + type.getTypeName() + " is not found",
                    ResultType.NOT_FOUND);
        } else {
            result.setPayload(repository.update(type));
            result.addMessage("success", ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Boolean> delete(Type type) {
        Result<Boolean> result = new Result<>();
        result.setPayload(false);

        if(!validateTypeName(type.getTypeName())) {
            result.addMessage("The provided type name " + type.getTypeName() + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (repository.findTypeByName(type.getTypeName()) == null) {
            result.addMessage("The provided type " + type.getTypeName() + " is not found",
                    ResultType.NOT_FOUND);
        } else {
            if(repository.delete(type)) {
                result.setPayload(true);
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            } else {
                result.addMessage("Failed to delete given type " + type.getTypeName(), ResultType.ERROR);
            }
        }
        return result;
    }

    private boolean validateTypeName(String typeName) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{2,25}$");
        Matcher matcher = pattern.matcher(typeName);
        return matcher.matches();
    }
}
