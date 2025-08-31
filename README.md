# movie-booking-platform

****Candidate Solution (XYZ Online Movie Booking Platform)**
**

****1. Functional Features (Mandatory Read/Write Scenario)**
**
****Chosen Read Scenario:**
**==> Browse theatres currently running the show (movie selected) in the town, including show timing by a chosen date.

****API Contract (Example in REST + JSON):**
**


GET /movies/{city}/{date}?language=EN&genre=Action


Response:
{
  "movie": "Inception",
  "city": "Singapore",
  "date": "2025-08-26",
  "theatres": [
    {
      "theatreId": "T101",
      "theatreName": "Golden Village",
      "shows": [
        { "showId": "S101", "time": "14:00", "availableSeats": 120 },
        { "showId": "S102", "time": "18:00", "availableSeats": 80 }
      ]
    }
  ]
}



****Chosen Write Scenario:**
**
==> **Book movie tickets by selecting a theatre, timing, and preferred seats for the day.**

****API Contract (Example):**
**
POST /bookings
Request:
{
  "userId": "U101",
  "theatreId": "T101",
  "showId": "S102",
  "seats": ["A1","A2","A3"],
  "paymentMode": "CREDIT_CARD"
}
Response:
{
  "bookingId": "B1001",
  "status": "CONFIRMED",
  "amountPaid": 1200,
  "discountApplied": "20% (Afternoon show)"
}




****Design Pattern:**
**
Factory Pattern → Payment Gateway integration (Razorpay, PayPal, Stripe).

Strategy Pattern → Apply discounts/offers dynamically.

Observer Pattern → Notify users (email/SMS) on booking confirmation or cancellation.

****2. Non-Functional Requirements (NFRs)**
**
Transactions & Consistency

Use ACID transactions for seat booking with row-level locking to prevent double booking.

Saga pattern for distributed transactions across Payment + Booking + Notification.

**Integration**

Provide REST/GraphQL APIs for partner theatres.

For legacy theatres, support CSV/Batch uploads and API adapters.

Scalability & Availability (99.99%)

Microservices architecture on Kubernetes (EKS/GKE/AKS).

Auto-scaling for booking, payment, search services.

CDN for movie posters/trailers.

Cache (Redis) for frequently searched shows/movies.

Payment Gateways

Integrate with Razorpay, Stripe, PayPal.

Support Wallets, UPI, Credit/Debit cards.

Monetization

Commission on ticket booking (10-15%).

Premium placement for theatres.

Ads/Promotions.

Security (OWASP Top 10)

JWT-based authentication (Spring Security).

Input validation & sanitization.

Rate limiting + API Gateway (Kong/Apigee).

Encrypted sensitive data (AES/RSA).

Regular pen-testing.

Compliance

GDPR (Europe), PCI-DSS (Payment).

Local tax regulations (GST, VAT).

**3. Platform Provisioning & Architecture
Technology Choices**

Backend: Java 17 + Spring Boot (Microservices)

Frontend (Future): Angular/React (not mandatory now)

**Database:**

PostgreSQL/MySQL for transactions.

MongoDB/ElasticSearch for movie search.

Messaging: Kafka/RabbitMQ (for async updates & notifications).

AI (Good to have):

Recommendation engine (collaborative filtering).

Dynamic pricing (demand-based).

Architecture (High-level)
[Client] → [API Gateway] → [Auth Service]  
 → [Booking Service] → [Payment Service] → [Notification Service]  
 → [Search Service] → [Theatre Management Service]  
 → [DB Layer: SQL + NoSQL + Cache]

Hosting & Sizing

Cloud: AWS preferred.

API Gateway → AWS API Gateway

DB → RDS (Multi-AZ), DynamoDB

Object Storage → S3 for posters/trailers

Monitoring → CloudWatch + ELK stack

Release Management

CI/CD using Jenkins/GitHub Actions.

Canary deployments with feature flags.

Geo-based rollout for APAC, EU, US.

I18N support (multi-language subtitles, UI).

Monitoring & KPIs

**Metrics:**

Avg booking latency (<500ms)

Failed booking transactions (%)

API availability

Revenue per city

Tools: ELK + Prometheus + Grafana


**High-level Project Plan (6 months MVP)**

Month 1: Requirement + Architecture finalization

Month 2-3: Core services (Booking, Theatre, Payment, Search)

Month 4: Integrations (payment, theatres) + Security

Month 5: Testing, scaling, monitoring setup

Month 6: Pilot launch (1-2 cities) + feedback
