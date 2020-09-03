# FidoWebTestAutomation
Owned by Digital QA Automation
[Under Construction]
How to Launch Tests

To run tests on SauceLabs
gradle sauceTest   -Ptest_browser=saucechrome -Ptest_language=en   --tests 'FidoCH_Regression*' -Ptest_threadCount=1 -Ptest_qaURL=https://qa6.fido.ca -i --stacktrace

To run tests on Local
gradle localTest   -Ptest_browser=chrome -Ptest_language=en   --tests 'FidoCH_Regression*' -Ptest_threadCount=1 -Ptest_qaURL=https://qa6.fido.ca -i --stacktrace

