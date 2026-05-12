# Test Cases & Results

| Scenario | Input | Expected Output | Result |
| :--- | :--- | :--- | :--- |
| **High Spend Audit** | Cursor, Business, 1 seat, $40 | Suggest Downgrade ($20 saved) | PASS |
| **Low Spend Audit** | ChatGPT, Plus, 1 seat, $20 | "Optimal" ($0 saved) | PASS |
| **Invalid Input** | (Empty Fields) | Frontend Validation Alert | PASS |
| **Persistence** | Run Audit with Email | Entry visible in H2 Console | PASS |