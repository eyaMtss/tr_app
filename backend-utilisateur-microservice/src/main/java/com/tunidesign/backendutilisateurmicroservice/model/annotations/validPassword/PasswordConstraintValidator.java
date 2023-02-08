package com.tunidesign.backendutilisateurmicroservice.model.annotations.validPassword;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
	Logger logger = LoggerFactory.getLogger(PasswordConstraintValidator.class);
	@Override
	public void initialize(final ValidPassword arg0) {
	}

	@SneakyThrows
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {

		List<Rule> rules = new ArrayList<>();
		// Rule 1: Password length should be in between 8 and 30 characters
		rules.add(new LengthRule(8, 30));
		// Rule 2: No whitespace allowed
		rules.add(new WhitespaceRule());
		// Rule 3.a: At least one Upper-case character
		rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
		// Rule 3.b: At least one Lower-case character
		rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
		// Rule 3.c: At least one digit
		rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
		// Rule 3.d: At least one special character
		rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

		PasswordValidator validator = new PasswordValidator(rules);
		RuleResult result = validator.validate(new PasswordData(password));
		if (result.isValid()) {
			logger.info("Valid password");
			return true;
		} else {
			logger.error("Invalid Password: " + validator.getMessages(result));
			List<String> messages = validator.getMessages(result);
			String messageTemplate = String.join(",", messages);
			context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation()
					.disableDefaultConstraintViolation();
			return false;
		}

	}

}
