# challengingDom

This is a CucumberBasedHybridFramework.
It is following Page Object Model & Singleton Design Pattern. It follows BDD Gherkin based Scenarios and generates a very fancy HTML & PDF report of the tes runs.
It also has the facility to rerun the failed scenario using rerun plugin.

# Prerequisites:

There might be few prerequisites which the team might have to install.
Dependency will automatically install from Maven central Repo
The project running system should also have Tessaract Library installed before hand. It's an open library and can be installed before.
As there weren't any Jenkins server links provided, I set it up using a local Jenkins and installing plugins like - htmlPulisher, Maven, pipeline integration.
