import org.junit.Before;
import org.junit.Test;
import org.opentestsystem.ap.common.config.ItemBankProperties;
import org.opentestsystem.ap.common.config.JwtSecurityConfiguration;
import org.opentestsystem.ap.common.security.SecurityUtil;
import org.opentestsystem.ap.common.security.jwt.JwtService;
import org.opentestsystem.ap.common.security.jwt.JwtSettings;
import org.opentestsystem.ap.common.security.model.User;

import static java.lang.System.getenv;

public class DefaultJwtServiceTest {
    private static final String TOKEN = "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNqckk1P20AQhv9KtGe0ElJPnEiLhSIFqGJziqNoWE_SKfthza5pDcp_73gNJAFaVRx3Pp6d9515UusuIqsz9VSrc2Mhxlqd1SrwVocWfcKYYh8TOg2tNsG54HVE0zGlXrvQoNW3AqjVSa3AmND5dB188bslxkZQiTs8Ss2DuT_KdOlHEBrh8POyVj_hAXSXyOopM_Rziknoy_fzxZbJbzcMDn8Fvt-PZQKjfuH2uiTXWrxkEDXN9CU8Trx_CXRxMy_Wt2WxqNVutZK0EQ3iAYGNH4lCB2RzJ0FajzZlO8-jA07Id2DBG2wG4_J_6OHOHiI2xDFdi4KMmU2rXLbprD0MTsrMnrw6TU1OneaHmLJHvK3MK5LM59c7EgffBisMiIkD_WoEf8qGLT2gf6c6izo9ydOBp0dIFPZV5ciafH2G5ZbDyqpvcTYgvkiiRXYUo4T_fVV5zbFj_zf_EmxzvJpdlZNp48jLcQwfiJVydeMelt8XN1XxrSouVrlpEP9K_C9Tdmr3BwAA__8.KQDVbZFmrYj2RMOs0qCgEzxRf9eIMy4zG_cMeloH4975AbeXEwai54FCWlUFPjmirXMh2KIpozYbQ6tHaMX8eA";
    private ItemBankProperties itemBankProperties;
    private JwtSecurityConfiguration configuration;
    private JwtSettings settings;
    private JwtService service;
    @Before
    public void setUp() {
        this.itemBankProperties = new ItemBankProperties();
        this.settings = new JwtSettings();
        this.settings.setSecret(getenv("TIMS_JWT_SECRET"));
        this.configuration = new JwtSecurityConfiguration();
        this.service = this.configuration.jwtService(this.settings);
    }
    @Test
    public void encode() {
        User user = SecurityUtil.buildSystemUser(this.itemBankProperties);
        String encodedJwtToken = this.service.encode(user);
        System.out.println(encodedJwtToken);
    }
    @Test
    public void decode() {
        User user = this.service.decode(TOKEN);
        System.out.println(user.getModel().getEmail());
    }
}

