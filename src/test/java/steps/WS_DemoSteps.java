package steps;

import java.util.List;

import com.pacifico.framework.Base;
import com.pacifico.framework.CucumberNewUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import services.TestDemo;

public class WS_DemoSteps extends Base{

    @Then("^I validate POST services$")
    public void iValidatePOSTServices(DataTable table) {

        CucumberNewUtil.ConvertDataTableToDict(table);
        List<List<String>> data = table.raw();

        for (int i = 1; i < data.size(); i++) {

            String aChannel = CucumberNewUtil.GetCellValueWithRowIndex("channel", i);
            int aStatusExpected = Integer.parseInt(CucumberNewUtil.GetCellValueWithRowIndex("status expected", i));

            TestDemo.validatePostRequest(aChannel);

            System.out.println("==========================================================================================");
            System.out.println("Passed test [" + i + "] Add new vehicle - Input [" + aChannel + "][" + aStatusExpected + "]");
            System.out.println("==========================================================================================");

        }
    }
}
