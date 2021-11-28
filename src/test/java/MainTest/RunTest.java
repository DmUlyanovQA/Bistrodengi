package MainTest;

import org.junit.jupiter.api.Test;

public class RunTest extends BeforeAfter{
    @Test
    public void test(){
    MainPage.goTO();
    MainPage.WriteBD("быстроденьги");
    MainPage.ClickBDandAssertTitle();
    }

}
