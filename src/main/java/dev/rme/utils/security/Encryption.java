package dev.rme.utils.security;

import com.axiara.axiaraapi.utils.Constants;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Map;

@Component
public class Encryption {
    public byte[] convertStringToByteArray(String string) {
        return string.getBytes();
    }

    public byte[] generateRandomByteArray(int length) {
        var bytes = new byte[length];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bytes);

        return bytes;
    }

    public Map.Entry<byte[], byte[]> deriveKey(String password) {
        var salt = generateRandomByteArray(Constants.SALT_LENGTH);
        PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator(new SHA256Digest());
        generator.init(
                convertStringToByteArray(password),
                salt,
                Constants.ITERATIONS
        );

        return Map.entry(salt, ((KeyParameter) generator.generateDerivedParameters(Constants.KEY_LENGTH)).getKey());
    }

    public Map.Entry<byte[], byte[]> deriveKey(String password, byte[] salt) {
        PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator(new SHA256Digest());
        generator.init(
                convertStringToByteArray(password),
                salt,
                Constants.ITERATIONS
        );

        return Map.entry(salt, ((KeyParameter) generator.generateDerivedParameters(Constants.KEY_LENGTH)).getKey());
    }

    public Boolean verifyKey(String rawPassword, byte[] encryptedPassword, byte[] salt) {
        var encryptedRawPassword = deriveKey(rawPassword, salt).getValue();
        return Arrays.equals(encryptedPassword, encryptedRawPassword);
    }
}
