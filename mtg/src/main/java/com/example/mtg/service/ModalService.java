package com.example.mtg.service;

import com.example.mtg.model.Modal;
import com.example.mtg.repository.repositoryInterfaces.ModalRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ModalService {
    @Autowired
    private ModalRepository repository;
    @Autowired
    private CardService cardService;

    public Result<Modal> findByFrontCardId(String cardId) {
        Result<Modal> result = new Result<>();
        result.setPayload(repository.findByFrontCardId(cardId));
        if(result.getPayload() == null) {
            result.addMessage("No cards found by given front card id " + cardId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Modal> findByBackCardId(String cardId) {
        Result<Modal> result = new Result<>();
        result.setPayload(repository.findByBackCardId(cardId));
        if(result.getPayload() == null) {
            result.addMessage("No cards found by given back card id " + cardId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Modal> findByModalId(String cardId) {
        Result<Modal> result = new Result<>();
        result.setPayload(repository.findByModalId(cardId));
        if(result.getPayload() == null) {
            result.addMessage("No cards found by given modal id " + cardId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Modal> add(Modal modal) {
        Result<Modal> result = new Result<>();

        if(!validateModal(modal)) {
            result.addMessage("The given modal " + modal + " is invalid", ResultType.INVALID);
        } else if (repository.findByModalId(modal.getModalId()) != null) {
            result.addMessage("The given modal " + modal + " already exists", ResultType.INVALID);
        } else {
            result.setPayload(repository.add(modal));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given modal " + modal, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public Result<Boolean> update(Modal modal) {
        Result<Boolean> result = new Result<>();

        if(!validateModal(modal)) {
            result.addMessage("The given modal " + modal + " is invalid", ResultType.INVALID);
        } else if (repository.findByModalId(modal.getModalId()) == null) {
            result.addMessage("The given modal " + modal + " doesn't exist", ResultType.INVALID);
        } else {
            result.setPayload(repository.update(modal));
            if(!result.getPayload()) {
                result.addMessage("Failed to update given modal " + modal, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public Result<Boolean> delete(Modal modal) {
        Result<Boolean> result = new Result<>();

        if(!validateModal(modal)) {
            result.addMessage("The given modal " + modal + " is invalid", ResultType.INVALID);
        } else if (repository.findByModalId(modal.getModalId()) == null) {
            result.addMessage("The given modal " + modal + " doesn't exist", ResultType.INVALID);
        } else {
            result.setPayload(repository.delete(modal.getModalId()));
            if(!result.getPayload()) {
                result.addMessage("Failed to delete given modal " + modal, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public boolean validateModal(Modal modal) {
        return validateModalId(modal.getModalId())
                && cardService.validateCard(modal.getfrontCard())
                && cardService.validateCard(modal.getbackCard());
    }

    private boolean validateModalId(String modalId) {
        Pattern pattern = Pattern.compile("^[A-Z\\d]{3}\\d{3}$");
        Matcher matcher = pattern.matcher(modalId);
        return matcher.matches();
    }

}
