package za.co.tman.workflow.cucumber.stepdefs;

import za.co.tman.workflow.WorkflowmoduleApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = WorkflowmoduleApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
