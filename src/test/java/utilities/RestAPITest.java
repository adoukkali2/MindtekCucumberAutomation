package utilities;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestAPITest {
    public static void main(String[] args) {
        /*
        Make get yard api call.
           Request
             1. URL -> Base URL & Endpoint
             2. Headers -> Authorization(Token), Accept (application/json)
             3. Method -> GET
           Response
             1. Status Code
             2. JSON Data
         */

        given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept", "application/json")
                .when().get("/yards/10/")
                .then().log().all();
        System.out.println("---------");
//
//        System.out.println(response.statusCode());
//        System.out.println(response.body().asString());
//
        /*
        POST call:
          Request
              1. URL -> BaseURL + Endpoint
              2. Headers -> Authorization(Token), Content-Type(application/json), Accept (application/json)
              3. Payload/ Body -> JSON
              4. Method -> POST
          Response:
              1. Status Code -> 201
              2. Body -> JSON

         */
        given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "    \"company_name\": \"hixgroYup\",\n" +
                        "    \"company_type\": \"broker company\",\n" +
                        "    \"status\": \"active\",\n" +
                        "    \"mc_number\": \"1254854\",\n" +
                        "    \"dot_number\": \"214954\",\n" +
                        "    \"ifta\": true,\n" +
                        "    \"address\": \"1243 oak rd\",\n" +
                        "    \"apt_suite_company_co\": null,\n" +
                        "    \"city\": \"chicago\",\n" +
                        "    \"state\": \"IL\",\n" +
                        "    \"zip_code\": \"60656\",\n" +
                        "    \"insurance\": \"Lego\",\n" +
                        "    \"producer_address\": \"345 ret rd\",\n" +
                        "    \"producer_apt_suite_company_co\": null,\n" +
                        "    \"producer_city\": \"Chicago\",\n" +
                        "    \"producer_state\": \"IL\",\n" +
                        "    \"producer_zip_code\": \"60656\",\n" +
                        "    \"policy_effective_day\": null,\n" +
                        "    \"policy_expiration\": null,\n" +
                        "    \"type_of_insurance\": null,\n" +
                        "    \"automobile_liability\": \"\",\n" +
                        "    \"num_of_truck_insured\": null,\n" +
                        "    \"policy_number\": null,\n" +
                        "    \"employer_id_num\": \"34-4544333\",\n" +
                        "    \"billing_address\": null,\n" +
                        "    \"bank_name\": null,\n" +
                        "    \"routing_number\": null,\n" +
                        "    \"account_number\": null,\n" +
                        "    \"president_full_name\": null,\n" +
                        "    \"trucks_in_fleet\": null,\n" +
                        "    \"scac_code\": \"\",\n" +
                        "    \"other_licenses\": false,\n" +
                        "    \"license_name\": null,\n" +
                        "    \"incorporated_in\": null,\n" +
                        "    \"notes\": null,\n" +
                        "    \"company_picture\": [],\n" +
                        "    \"company_documents\": [],\n" +
                        "    \"contacts\": [\n" +
                        "        {\n" +
                        "            \"phone\": \"324-768-9876\",\n" +
                        "            \"ext\": \"\",\n" +
                        "            \"contact_name\": \"\",\n" +
                        "            \"email\": \"fdr@gmail.com\",\n" +
                        "            \"fax\": \"\",\n" +
                        "            \"producer_phone\": \"455-665-8888\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\",\n" +
                        "            \"producer_email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"phone_number\": [\n" +
                        "        {\n" +
                        "            \"phone\": \"324-768-9876\",\n" +
                        "            \"ext\": \"\",\n" +
                        "            \"contact_name\": \"\",\n" +
                        "            \"email\": \"fdr@gmail.com\",\n" +
                        "            \"fax\": \"\",\n" +
                        "            \"producer_phone\": \"455-665-8888\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\",\n" +
                        "            \"producer_email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"fax_number\": [\n" +
                        "        {\n" +
                        "            \"fax\": \"\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"email_number\": [\n" +
                        "        {\n" +
                        "            \"email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"producer_email_number\": [\n" +
                        "        {\n" +
                        "            \"producer_email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"producer_phone_number\": [\n" +
                        "        {\n" +
                        "            \"producer_phone\": \"455-665-8888\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .when().post("/companies/")
                .then().log().all();
/*
        Patch Call
           Request:
              1. URL -> BaseURL + Endpoint
              2. Headers -> Authorization(Token), Content-Type(application/json), Accept (application/json)
              3. Payload -> JSON
              4. Method -> PATCH
           Response:
              1. Status Code -> 200
              2. Body -> JSON
         */

        given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "    \"company_name\": \"hixgroYup\",\n" +
                        "    \"company_type\": \"broker company\",\n" +
                        "    \"status\": \"active\",\n" +
                        "    \"mc_number\": \"123456854\",\n" +
                        "    \"dot_number\": \"234454\",\n" +
                        "    \"ifta\": true,\n" +
                        "    \"address\": \"123 oak rd\",\n" +
                        "    \"apt_suite_company_co\": null,\n" +
                        "    \"city\": \"chicago\",\n" +
                        "    \"state\": \"IL\",\n" +
                        "    \"zip_code\": \"60656\",\n" +
                        "    \"insurance\": \"Lego\",\n" +
                        "    \"producer_address\": \"345 ret rd\",\n" +
                        "    \"producer_apt_suite_company_co\": null,\n" +
                        "    \"producer_city\": \"Chicago\",\n" +
                        "    \"producer_state\": \"IL\",\n" +
                        "    \"producer_zip_code\": \"60656\",\n" +
                        "    \"policy_effective_day\": null,\n" +
                        "    \"policy_expiration\": null,\n" +
                        "    \"type_of_insurance\": null,\n" +
                        "    \"automobile_liability\": \"\",\n" +
                        "    \"num_of_truck_insured\": null,\n" +
                        "    \"policy_number\": null,\n" +
                        "    \"employer_id_num\": \"34-4544333\",\n" +
                        "    \"billing_address\": null,\n" +
                        "    \"bank_name\": null,\n" +
                        "    \"routing_number\": null,\n" +
                        "    \"account_number\": null,\n" +
                        "    \"president_full_name\": null,\n" +
                        "    \"trucks_in_fleet\": null,\n" +
                        "    \"scac_code\": \"\",\n" +
                        "    \"other_licenses\": false,\n" +
                        "    \"license_name\": null,\n" +
                        "    \"incorporated_in\": null,\n" +
                        "    \"notes\": null,\n" +
                        "    \"company_picture\": [],\n" +
                        "    \"company_documents\": [],\n" +
                        "    \"contacts\": [\n" +
                        "        {\n" +
                        "            \"phone\": \"324-768-9876\",\n" +
                        "            \"ext\": \"\",\n" +
                        "            \"contact_name\": \"\",\n" +
                        "            \"email\": \"fdr@gmail.com\",\n" +
                        "            \"fax\": \"\",\n" +
                        "            \"producer_phone\": \"455-665-8888\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\",\n" +
                        "            \"producer_email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"phone_number\": [\n" +
                        "        {\n" +
                        "            \"phone\": \"324-768-9876\",\n" +
                        "            \"ext\": \"\",\n" +
                        "            \"contact_name\": \"\",\n" +
                        "            \"email\": \"fdr@gmail.com\",\n" +
                        "            \"fax\": \"\",\n" +
                        "            \"producer_phone\": \"455-665-8888\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\",\n" +
                        "            \"producer_email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"fax_number\": [\n" +
                        "        {\n" +
                        "            \"fax\": \"\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"email_number\": [\n" +
                        "        {\n" +
                        "            \"email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"producer_email_number\": [\n" +
                        "        {\n" +
                        "            \"producer_email\": \"fdr@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"producer_phone_number\": [\n" +
                        "        {\n" +
                        "            \"producer_phone\": \"455-665-8888\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .when().patch("/companies/193/")
                .then().log().all();
    }
}