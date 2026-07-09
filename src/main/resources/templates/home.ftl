<#import "client/templ-client.ftl" as p>
<@p.pages>

    <div class="p-5 mb-5 bg-dark text-white rounded-3 shadow-lg position-relative overflow-hidden"
         style="background-image: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)), url('https://images.unsplash.com/photo-1507842217343-583bb7270b66?q=80&w=1600&auto=format&fit=crop'); background-size: cover; background-position: center; min-height: 500px; display: flex; align-items: center;">

        <div class="container-fluid py-5 position-relative z-index-1">
            <h1 class="display-3 fw-bold">Explore the World of Knowledge</h1>
            <p class="col-md-8 fs-4">Thousands of books, scientific articles, and journals are available for you. Book online, read offline.</p>
            <div class="mt-4">
                <a href="/catalog" class="btn btn-primary btn-lg px-4 me-md-2 fw-bold"><i class="bi bi-book me-2"></i> Browse Catalog</a>
                <a href="/registration" class="btn btn-outline-light btn-lg px-4 fw-bold">Join as Reader</a>
            </div>
        </div>
    </div>

    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3 text-center border-bottom mb-5">
        <div class="col">
            <div class="feature-icon bg-primary bg-gradient text-white rounded-circle d-inline-flex align-items-center justify-content-center mb-3" style="width: 60px; height: 60px;">
                <i class="bi bi-collection fs-3"></i>
            </div>
            <h3 class="fs-4">Huge Collection</h3>
            <p class="text-muted">Over 10,000 books: from world classics to modern bestsellers and scientific literature.</p>
        </div>
        <div class="col">
            <div class="feature-icon bg-success bg-gradient text-white rounded-circle d-inline-flex align-items-center justify-content-center mb-3" style="width: 60px; height: 60px;">
                <i class="bi bi-clock-history fs-3"></i>
            </div>
            <h3 class="fs-4">Quick Reservation</h3>
            <p class="text-muted">Forget about queues. Reserve a book online and it will be waiting for you at the pickup desk.</p>
        </div>
        <div class="col">
            <div class="feature-icon bg-warning bg-gradient text-dark rounded-circle d-inline-flex align-items-center justify-content-center mb-3" style="width: 60px; height: 60px;">
                <i class="bi bi-laptop fs-3"></i>
            </div>
            <h3 class="fs-4">User Dashboard</h3>
            <p class="text-muted">Track your reading history, due dates, and stay updated with new arrivals.</p>
        </div>
    </div>

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="fw-bold text-dark border-start border-5 border-primary ps-3">What to read?</h2>
        <a href="/catalog" class="text-decoration-none">All Categories <i class="bi bi-arrow-right"></i></a>
    </div>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4 mb-5">
        <#if categories??>
            <#list categories as category>
                <div class="col">
                    <a href="catalog/category/${category.id}" class="text-decoration-none">
                        <div class="card h-100 border-0 shadow-sm category-card text-white overflow-hidden position-relative" style="height: 250px;">

                            <div class="category-bg-image"
                                 style="background-image: url('${category.image}')">
                            </div>

                            <div class="card-img-overlay d-flex flex-column justify-content-center align-items-center p-0">
                                <div class="bg-dark bg-opacity-50 w-100 h-100 d-flex flex-column justify-content-center align-items-center content-overlay">
                                    <h3 class="card-title fw-bold text-uppercase tracking-wider mb-0">${category.name}</h3>
                                    <span class="btn btn-outline-light btn-sm mt-3 rounded-pill px-4 hover-show">View Books</span>
                                </div>
                            </div>

                        </div>
                    </a>
                </div>
            </#list>
        <#else>
            <p class="text-muted">Loading categories...</p>
        </#if>
    </div>
    <style>
        .category-card {
            border-radius: 15px;
            cursor: pointer;
        }
        /* Стиль для картинки фону */
        .category-bg-image {
            width: 100%;
            height: 250px;
            background-size: cover;
            background-position: center;
            transition: transform 0.6s ease; /* Плавний зум */
        }
        /* При наведенні мишки на картку - збільшуємо картинку */
        .category-card:hover .category-bg-image {
            transform: scale(1.1);
        }
        /* Анімація появи кнопки */
        .hover-show {
            transition: opacity 0.3s ease, transform 0.3s ease;
            transform: translateY(20px);
        }
        .category-card:hover .hover-show {
            opacity: 1;
            transform: translateY(0);
        }
        /* Трохи світліше затемнення при наведенні */
        .content-overlay {
            transition: background-color 0.3s;
        }
        .category-card:hover .content-overlay {
            background-color: rgba(0, 0, 0, 0.3) !important; /* Було 0.5, стало 0.3 (світліше) */
        }
    </style>
    <div class="bg-light p-5 rounded-3 border text-center mb-5">
        <h2 class="fw-bold">Didn't find the book you need?</h2>
        <p class="lead text-muted">We are constantly updating our collection. Register to suggest new books.</p>
        <a href="/contacts" class="btn btn-outline-dark btn-lg">Contact Us</a>
    </div>



</@p.pages>