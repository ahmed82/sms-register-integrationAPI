"# sms-register-integrationAPI" 

## Test Endpoint 
* Method Post
* Url: http://localhost:8080/api/points
* 
## Test JSON object
```json
{
    "phone_number": "964750303xxxx",
    "message_text": "Test SMS API from the Java Restful API ;) Ahmed -Cheers!!!"
}
```
## Get Total points
```
curl --location --request GET 'https://api.foodics.com/v5/loyalty_transactions?filter[customer_id]={UUID}' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLvRH...........' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'
```


https://apidocs.foodics.com/core/resources/loyalty.html#list-loyalty-transactions
https://apidocs.foodics.com/core/webhooks.html#what-is-a-webhook
