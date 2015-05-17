package aes;

public class PrivateConfig {

	private String keyStoreLocation;
	private String passwordToKeyStore;
	private String keyAlias;
	private String passwordToKey;
	public String getKeyStoreLocation() {
		return keyStoreLocation;
	}
	public void setKeyStoreLocation(String keyStoreLocation) {
		this.keyStoreLocation = keyStoreLocation;
	}
	public String getPasswordToKeyStore() {
		return passwordToKeyStore;
	}
	public void setPasswordToKeyStore(String passwordToKeyStore) {
		this.passwordToKeyStore = passwordToKeyStore;
	}
	public String getKeyAlias() {
		return keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}
	public String getPasswordToKey() {
		return passwordToKey;
	}
	public void setPasswordToKey(String passwordToKey) {
		this.passwordToKey = passwordToKey;
	}
	
}
