## Risk Engine considerations:

This micro-service contains:
### Behavior-based Modeling 
  * Identify key transactional behaviors and spending patterns to recognize uncharacteristic transactions
  * Device finger printing
    - Device, SIM ID, Point of Compromise
    - IP profiling: Whitelist, Blacklist, Transactions from same IP
    - User profiling: Favorite IP, Device, Merchant, Payment behavior, history
    - Merchant profiling: PAN, MCC, Country
### Analytics and Machine Learning
  * Predictive, adaptive, and statistical analytics to deliver insight into potential fraudulent transactions
  * Reduce manual review queues through fast iterating ML models
  * Report false positives and learn to refine algorithms
### Case Management
  * Comprehensive tracking system that allows high level investigation and end to end case management
  * Simple and effective user interface
  * Automated case management via IVR
  * Risk based authentication via biometric, OTP
  * Reports with detailed score analysis, weightage per rule
### External Data Capture
  * Communicates with external data sources to create customer data, account and product information
  * External sources such as Aadhar, facial recognition, social media, settlement files, chargeback files, regulatory data
### Data Integration
  * Seamless integrations with systems such as ATM, POS, e-commerce, mobile banking, net banking internal systems 
    to create one customer view for efficient analysis
### Actionable Insights via API
  * Transactions score
  * Top spends customer wise
  * Total amount spends
  * Lists such as blacklisted IP, merchants
  

### Considerations related to risk analysis policies
Going to use Strategy Pattern i.e. different strategies can be implemented and chosen by client.

```
INSERT INTO payment(ammount, currency_id, payer_id, payee_id, payment_method_id, succeeded)
VALUES (78.90, (SELECT currency_id FROM currency WHERE iso_name = 'USD'),
        (SELECT payee_id FROM payee  WHERE first_name = 'Philip J.'),
        (SELECT payment_method_id FROM payment_method WHERE payment.payer_id IN (SELECT payer_id FROM payer WHERE first_name = 'Lisa')), 'true'); 
```

## How to build a docker image
```
docker build -t riskengine:100 .
```

## How to deploy locally
```
docker run -d --name risk-image riskengine:100 
```
 80d973ca43f97c7215f027bae7f6967c8d5c5a9d
