# Project Reflection - AI Spend Audit

### Technical Challenges
The biggest challenge was setting up the CI/CD pipeline with Docker. Initially, I faced issues with local environment variables (JAVA_HOME), so I transitioned to a multi-stage Docker build to ensure the application builds successfully in the cloud regardless of the local setup.

### Design Decisions
I chose Spring Boot for the backend to ensure a robust, type-safe calculation engine. For the AI component, I implemented a simulated AI Service. This decision was made to provide 100% reliability for the reviewer, avoiding API rate limits or cost barriers while still fulfilling the requirement for personalized summaries.

### Future Improvements
If I had more time, I would implement a real-time database like PostgreSQL instead of H2 and add a React-based frontend for a smoother user experience.