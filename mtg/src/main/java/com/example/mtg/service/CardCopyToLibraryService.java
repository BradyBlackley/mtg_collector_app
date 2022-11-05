package com.example.mtg.service;

import com.example.mtg.model.CardCopy;
import com.example.mtg.model.CardCopyToLibrary;
import com.example.mtg.repository.repositoryInterfaces.CardCopyToLibraryRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardCopyToLibraryService {
    @Autowired
    CardCopyToLibraryRepository repository;
    @Autowired
    CardCopyService cardCopyService;
    @Autowired
    LibraryService libraryService;

    Result<CardCopyToLibrary> findByLibraryId(CardCopyToLibrary cardCopyToLibrary) {
        Result<CardCopyToLibrary> result = new Result<>();
        result.setPayload(repository.findByLibraryId(cardCopyToLibrary.getLibrary().getLibraryId()));
        if(result.getPayload() == null) {
            result.addMessage("No card copies found associated with given library "
                    + cardCopyToLibrary.getLibrary(), ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    Result<CardCopyToLibrary> add(CardCopyToLibrary cardCopyToLibrary) {
        Result<CardCopyToLibrary> result = new Result<>();
        if(!validateCardCopyToLibrary(cardCopyToLibrary)) {
            result.addMessage("Card copy or library associated with given card copy to library is not valid",
                    ResultType.INVALID);
        } else if (repository.findByLibraryId(cardCopyToLibrary.getLibrary().getLibraryId()) != null) {
            result.addMessage("Card copy to library already exists",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.add(cardCopyToLibrary));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given card copy to library " + cardCopyToLibrary,
                        ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    Result<Boolean> update(CardCopyToLibrary cardCopyToLibrary) {
        Result<Boolean> result = new Result<>();
        if(!validateCardCopyToLibrary(cardCopyToLibrary)) {
            result.addMessage("Card copy or library associated with given card copy to library is not valid",
                    ResultType.INVALID);
        } else if (repository.findByLibraryId(cardCopyToLibrary.getLibrary().getLibraryId()) == null) {
            result.addMessage("Given card copy to library is not found",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.update(cardCopyToLibrary));
            if(!result.getPayload()) {
                result.addMessage("Failed to update given card copy to library " + cardCopyToLibrary,
                        ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    Result<Boolean> delete(CardCopyToLibrary cardCopyToLibrary) {
        Result<Boolean> result = new Result<>();
        if(!validateCardCopyToLibrary(cardCopyToLibrary)) {
            result.addMessage("Card copy or library associated with given card copy to library is not valid",
                    ResultType.INVALID);
        } else if (repository.findByLibraryId(cardCopyToLibrary.getLibrary().getLibraryId()) == null) {
            result.addMessage("Given card copy to library is not found",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.delete(cardCopyToLibrary));
            if(!result.getPayload()) {
                result.addMessage("Failed to delete given card copy to library " + cardCopyToLibrary,
                        ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public boolean validateCardCopyToLibrary(CardCopyToLibrary cardCopyToLibrary) {
        boolean isValidCardCopy = true;
        for (CardCopy cardCopy : cardCopyToLibrary.getCardCopies()) {
            if (!cardCopyService.validateCardCopy(cardCopy)) {
                isValidCardCopy = false;
            }
        }
        return isValidCardCopy && libraryService.validateLibrary(cardCopyToLibrary.getLibrary());
    }

}
