package com.enterpriseflow.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		
		// abhi ke liye static value return kar rahe hain
        // kyunki abhi security implement nahi hua.
		
		return Optional.of("SYSTEM");
		
		// jab security implement ho jayega
        // tab yaha se SecurityContextHolder se username nikalenge
	}
	
	
	
}