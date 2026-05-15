---
trigger: always_on
---

# Project Standards: Kotlin Multiplatform with Compose Multiplatform Monorepo
## Technology Stack
- **Framework:** Compose Multiplatform (CMP)
- **Backend:** Ktor (Kotlin Server-Side)
- **DI:** Metro (Compile-time dependency injection)
- **Database:** Room KMP
- **Serialization:** kotlinx.serialization

## Architectural Rules
1. **Shared Models:** All network responses must live in `:api-models`. 
2. **DI Pattern:** Use `@DependencyGraph` for Metro. Do not use Koin.
3. **Async:** Always use Kotlin Coroutines (Flow/Suspend) for IO.
4. **Multiplatform:** Keep logic in `commonMain` of the `:shared` module.

## Project Structure
- `app/androidApp` - Android application source code
- `app/composeApp` - compose multiplatform application code with subdirectories for platform specific logic
- `docs` - project documentation
- `feature` - feature modules for frontend (web, desktop and mobile) used in navigation in `app/composeApp`
- `server` - backend
- `shared` - shared common code
- `shared-ui` - shared UI for frontend (app and feature modules)