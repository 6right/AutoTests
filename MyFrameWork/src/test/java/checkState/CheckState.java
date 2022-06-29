package checkState;

import base.Tests.BaseTest;
import org.testng.annotations.Test;

import static Constants.Constant.Urls.ToolsQA_HOME;

public class CheckState extends BaseTest {

    @Test
    public void checkStateList(){
        basePage.open(ToolsQA_HOME);

        qaMainPage
               .joinForm()
                .listOut();

        qaList.checkCount();
    }
}
