package es.dmoral.toastysample;

import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {
    @Test
    public void onStart() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("es.dmoral.toastysample.hmservice", actualBundleName);
    }
}
