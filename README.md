# challengingDom

This is a CucumberBasedHybridFramework.
It is following Page Object Model & Singleton Design Pattern. It follows BDD Gherkin based Scenarios and generates a very fancy SPARK HTML & PDF report of the test runs.
It also has the facility to rerun the failed scenario using rerun plugin. Can be integrated with Jenkins using Jenkins File.

# Prerequisites:

There might be few prerequisites which the team might have to install.
1. Dependency will automatically install from Maven central Repo
2. The project running system should also have Tessaract Library installed before hand. It's an open library and can be installed before.
3. As there weren't any Jenkins server links provided, I set it up using a local Jenkins
4. Installing plugins like - htmlPulisher, Maven, pipeline integration in jenkins
