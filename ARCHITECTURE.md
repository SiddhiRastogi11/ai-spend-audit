# System Architecture — AI Spend Audit

## Tech Stack
- **Backend:** Java / Spring Boot 3.x (Maven)
- **Frontend:** Vanilla JavaScript, HTML5, Tailwind CSS
- **Database:** H2 (In-memory for local) / PostgreSQL (Production)
- **CI/CD:** GitHub Actions (Maven Build & Test)

## Data Flow
1. **User Input:** The frontend collects tool names, plans, and seat counts.
2. **Audit Engine:** A Spring Boot Service processes this data against hardcoded pricing rules.
3. **Lead Capture:** User emails are stored via JPA to a SQL database.
4. **Summary:** An LLM generates a personalized optimization paragraph based on the math.

## Why Spring Boot?
I chose Spring Boot because it provides a robust, type-safe environment for the "Audit Engine." The layered architecture (Controller -> Service -> Repository) ensures that the business logic for pricing is decoupled from the web layer, making it easy to test and scale.