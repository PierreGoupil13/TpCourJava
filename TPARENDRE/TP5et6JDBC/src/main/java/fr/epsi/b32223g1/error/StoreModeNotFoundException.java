package fr.epsi.b32223g1.error;

public class StoreModeNotFoundException extends Exception {
	
	private String mode;
	
	public StoreModeNotFoundException( String mode ) {
		this.mode = mode;
	}
	
	@Override
	public String getMessage() {
		return String.format( "Le mode '%s' n'est pas implémenté !", mode );
	}
	
	public String getMode() {
		return mode;
	}
}
