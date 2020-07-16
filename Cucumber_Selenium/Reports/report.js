$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Customers.feature");
formatter.feature({
  "line": 1,
  "name": "Customers",
  "description": "",
  "id": "customers",
  "keyword": "Feature"
});
formatter.before({
  "duration": 11245090005,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Below are the common steps for each scenario",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "User Launch Chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User opens URL \"http://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User enters Email as \"admin@yourstore.com\" and Password as \"admin\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Click in Login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User can view Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_Launch_Chrome_browser()"
});
formatter.result({
  "duration": 397253671,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://admin-demo.nopcommerce.com/login",
      "offset": 16
    }
  ],
  "location": "Steps.user_opens_URL(String)"
});
formatter.result({
  "duration": 1586037029,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin@yourstore.com",
      "offset": 22
    },
    {
      "val": "admin",
      "offset": 60
    }
  ],
  "location": "Steps.user_enters_Email_as_and_Password_as(String,String)"
});
formatter.result({
  "duration": 491286120,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_in_Login()"
});
formatter.result({
  "duration": 3122819754,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_can_view_Dashboard()"
});
formatter.result({
  "duration": 29906443,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Search Customer by EmailId",
  "description": "",
  "id": "customers;search-customer-by-emailid",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@searchCustomer"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "User click on Customers Menu",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "Click on customers Menu Item",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "Enter Customer Email",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "Click on search button",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "User should found Email in the Search table",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_click_on_Customers_Menu()"
});
formatter.result({
  "duration": 5420260935,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_customers_Menu_Item()"
});
formatter.result({
  "duration": 4473292278,
  "status": "passed"
});
formatter.match({
  "location": "Steps.enter_Customer_Email()"
});
formatter.result({
  "duration": 514613927,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_search_button()"
});
formatter.result({
  "duration": 3112137612,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_should_found_Email_in_the_Search_table()"
});
formatter.result({
  "duration": 354158377,
  "status": "passed"
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "duration": 1370623322,
  "status": "passed"
});
});