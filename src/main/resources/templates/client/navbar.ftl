<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm sticky-top">
    <div class="container">

        <a class="navbar-brand fw-bold text-white" href="/">
            <i class="bi bi-book-half"></i> BiblioTech
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link text-white" href="/catalog">Catalog</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="/about-us">About Us</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="/contacts">Contacts</a></li>
            </ul>


            <form  method="get" class="d-flex me-lg-3 mb-3 mb-lg-0" action="/catalog/search">
                <input class="form-control me-2 border-0" type="search" name="title" placeholder="Search books...">
                <button class="btn btn-outline-light" type="submit"><i class="bi bi-search"></i></button>
            </form>

            <ul class="navbar-nav align-items-center">
                <#if Session?? && Session.SPRING_SECURITY_CONTEXT??>

                    <li class="nav-item me-2">
                        <a class="nav-link position-relative text-white" href="/cart" title="My Cart">
                            <i class="bi bi-cart3 fs-5"></i>
                        </a>
                    </li>

                    <li class="nav-item me-3">
                        <a class="nav-link fw-bold text-white" href="/cabinet">
                            <i class="bi bi-person-circle"></i> Dashboard
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="btn btn-danger btn-sm fw-bold shadow-sm" href="/logout">
                            <i class="bi bi-box-arrow-right"></i> Logout
                        </a>
                    </li>

                <#else>

                    <li class="nav-item me-2">
                        <a class="nav-link fw-medium text-white" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-light text-primary btn-sm fw-bold shadow-sm" href="/registration">
                            Register
                        </a>
                    </li>

                </#if>
            </ul>

        </div>
    </div>
</nav>