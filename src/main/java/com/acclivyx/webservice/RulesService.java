package com.acclivyx.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.acclivyx.main.RuleRunnerDemo;
import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;
import com.acclivyx.rules.model.Data;

@Path("/rules")
public class RulesService {

	@GET
	@Path("/json/{input}")
	@Produces("application/json")
	public List<RuleResult> runRule(@PathParam("input") String input)
			throws RuleArgsInvalid {
		List<RuleResult> results = new ArrayList<RuleResult>();

		Data data = new Data();
		data.setInput(input);

		RulesFactory rulesFactory = new RulesFactory(data.args());

		rulesFactory.getRuleArgs();
		RuleRunnerDemo demo = new RuleRunnerDemo();

		results = new ArrayList<RuleResult>(demo.process(rulesFactory));

		return results;
	}
}
