# 💊 صيدلية الأمين الحديثة — Al-Amin Modern Pharmacy

تطبيق Android احترافي + لوحة تحكم ويب متكاملة لصيدلية الأمين الحديثة.

---

## ✨ المميزات

### 📱 تطبيق Android
- 🏠 **الرئيسية:** بانرات ديناميكية + خدمات + أقسام + منتجات مميزة
- 📂 **الأقسام:** تصفّح منتجات حسب الفئة (أدوية، تجميل، أطفال، فيتامينات...)
- 🔍 **البحث:** بحث فوري في كل المنتجات مع فلتر بالأصناف
- 🛒 **السلة:** إضافة منتجات + إرسال الطلب عبر واتساب
- 📤 **رفع الوصفة:** اختيار صورة + ملاحظات + إرسال للصيدلية
- 💬 **استشارة طبية:** نموذج استفسار يرسل عبر واتساب
- ⏰ **منبه الدواء:** إضافة/تعديل/حذف منبهات الأدوية
- 👤 **الحساب:** كل بيانات التواصل (واتساب، اتصال، إيميل، موقع، فيسبوك)

### 🌐 لوحة تحكم الويب (Admin Dashboard)
- 🔐 تسجيل دخول آمن
- 📊 إحصائيات فورية
- 📂 إدارة الأصناف (إضافة/تعديل/حذف)
- 💊 إدارة المنتجات (مع صور وأسعار وعروض)
- 🎯 إدارة البانرات الإعلانية
- 🏷️ إدارة العروض والخصومات
- 📞 تعديل معلومات التواصل

### 🎨 الهوية البصرية
- ألوان فيروزي فاتح + أبيض (نفس هوية الصيدلية)
- شعار فيروزي (شبيهة بـ "Aura Pharma" مع تخصيص كامل)
- خطوط عربية أنيقة
- واجهة RTL كاملة

---

## 🏗️ بنية المشروع

```
alamin-pharma/
├── app/                          # تطبيق Android (Kotlin + Compose)
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/alamin/pharma/
│       │   ├── AlAminApp.kt
│       │   ├── MainActivity.kt
│       │   ├── data/
│       │   │   ├── Models.kt           # نماذج البيانات
│       │   │   └── PharmacyRepository.kt  # طبقة الوصول لـ Firebase
│       │   ├── ui/
│       │   │   ├── AlAminAppRoot.kt    # الجذر + التنقل
│       │   │   ├── PharmacyViewModel.kt
│       │   │   ├── theme/
│       │   │   ├── components/
│       │   │   └── screens/             # كل الشاشات
│       │   └── utils/ContactUtils.kt
│       └── res/                          # الموارد
├── admin-web/                     # لوحة التحكم (HTML/JS)
│   ├── index.html
│   ├── css/admin.css
│   └── js/admin.js
├── firebase/                      # إعدادات Firebase
│   ├── firestore.rules            # قواعد الأمان
│   ├── firestore.indexes.json     # فهارس الأداء
│   └── google-services.json.template
├── .github/workflows/
│   └── build-apk.yml              # بناء APK تلقائي
└── README.md (هذا الملف)
```

---

## 🚀 خطوات الإعداد الكاملة (5 خطوات)

### الخطوة 1: إنشاء مشروع Firebase

1. افتح [Firebase Console](https://console.firebase.google.com)
2. اضغط **Add project** → سمّه `alamin-pharma` → **Continue**
3. فعّل/عطّل Google Analytics (اختياري) → **Create project**

### الخطوة 2: إعداد Android App في Firebase

1. من نظرة عامة على المشروع، اضغط أيقونة **Android**
2. **Android package name:** `com.alamin.pharma`
3. **App nickname:** `AlAmin Pharma`
4. **Debug signing certificate:** اتركه فارغ للحين
5. اضغط **Register app**
6. حمّل ملف **`google-services.json`** وانسخه إلى: `app/google-services.json`

### الخطوة 3: تفعيل الخدمات

#### Authentication (المصادقة)
1. القائمة الجانبية → **Authentication** → **Get started**
2. Sign-in method → فعّل **Email/Password**

#### Firestore Database
1. القائمة الجانبية → **Firestore Database** → **Create database**
2. اختر **Production mode** → **Next**
3. اختر موقع (eur3 أو asia-south1) → **Enable**
4. من تبويب **Rules**، استبدل المحتوى بمحتوى `firebase/firestore.rules`
5. اضغط **Publish**

#### تفعيل الفهارس
1. من تبويب **Indexes** → **Add index** → استورد ملف `firebase/firestore.indexes.json`
   أو شغّل:
   ```bash
   firebase deploy --only firestore:indexes
   ```

### الخطوة 4: إضافة حساب المدير

1. **Authentication** → **Users** → **Add user**
2. Email: `admin@alamin-pharma.com` (أو أي إيميل)
3. Password: اختر كلمة سر قوية
4. **Add user**

### الخطوة 5: تجهيز لوحة التحكم (Admin Web)

1. افتح `admin-web/js/admin.js`
2. استبدل `firebaseConfig` بإعداداتك من:
   Firebase Console → Project Settings → General → Your apps → Web app
3. (اختياري) انشر لوحة التحكم على **GitHub Pages** أو **Netlify** أو **Vercel** (مجاني)

---

## 📦 بناء APK

### الخيار A: عبر GitHub Actions (موصى به)

1. ارفع المشروع على GitHub
2. Settings → Secrets and variables → Actions
3. **New repository secret** → Name: `GOOGLE_SERVICES_JSON` → Value: محتوى ملف `google-services.json` بالكامل (JSON)
4. تبويب **Actions** → **Build Android APK** → **Run workflow**
5. بعد 5-10 دقائق، نزّل APK من **Artifacts**

### الخيار B: عبر Android Studio

1. افتح Android Studio → **File → Open** → اختر مجلد `alamin-pharma/`
2. ضع ملف `google-services.json` الحقيقي في `app/`
3. **Build → Build Bundle(s) / APK(s) → Build APK(s)**

### الخيار C: عبر سطر الأوامر

```bash
cd alamin-pharma
./gradlew assembleRelease
# APK in app/build/outputs/apk/release/app-release.apk
```

---

## 📞 بيانات التواصل (مدمجة)

| البند | القيمة |
|------|------|
| واتساب (عام) | +967774973636 |
| واتساب (الوصفات) | +967784332800 |
| هاتف | +967774973636 |
| البريد | alaminmodern.ph@gmail.com |
| العنوان | اليمن - إب - مدينة القاعدة |
| فيسبوك | https://www.facebook.com/share/18BNE6VzVK/ |
| ساعات العمل | يومياً 8 ص - 11 م |

*(يمكن تعديلها من لوحة التحكم أو من `data/Models.kt`)*

---

## 🎯 المهام المكتملة

- ✅ شاشة رئيسية كاملة مع بانرات ديناميكية
- ✅ صفحة أقسام بمنتجات قابلة للتصفح
- ✅ بحث متقدم (نص + صنف)
- ✅ رفع وصفة طبية مع صورة
- ✅ استشارة طبية عبر واتساب
- ✅ سلة مشتريات + إرسال طلب
- ✅ منبه أدوية (محلي، لا يحتاج نت)
- ✅ شاشة حساب مع كل بيانات التواصل
- ✅ لوحة تحكم ويب متكاملة
- ✅ تكامل Firebase كامل
- ✅ بناء APK تلقائي عبر GitHub Actions
- ✅ أمان Firestore مع Authentication

---

## 🆘 حل المشاكل

| المشكلة | الحل |
|------|------|
| "google-services.json missing" | ضع الملف في `app/` |
| "Build failed: Firebase" | تأكد من مطابقة package name في `google-services.json` |
| "Permission denied" في Firestore | تأكد من لصق `firestore.rules` بشكل صحيح |
| "Index not found" | انشر `firestore.indexes.json` وانتظر 5-10 دقائق |
| التطبيق لا يعرض منتجات | أضف منتجات من لوحة التحكم أو مباشرة في Firestore |
| لوحة التحكم لا تعمل | تأكد من إعداد `firebaseConfig` بشكل صحيح |
| البحث بطيء | انشر الفهارس في Firebase Console |

---

## 📝 ملاحظات

- **التخزين المجاني:** Firebase يعطيك 1GB تخزين + 10GB نقل/شهر
- **عدد القراءات:** 50,000 قراءة/يوم مجاناً
- **استضافة لوحة التحكم:** GitHub Pages أو Netlify (مجاني)
- **التحديثات:** أي تعديل في Firebase يظهر فوراً في التطبيق (real-time)

---

## 🤝 المساهمة

لإضافة ميزة جديدة:
1. أضف الـ model في `data/Models.kt`
2. أضف دالة في `PharmacyRepository.kt`
3. أضف حالة في `PharmacyViewModel.kt`
4. أنشئ شاشة في `ui/screens/`
5. أضف route في `AlAminAppRoot.kt`

---

> صنع بعناية 💚 لصيدلية الأمين الحديثة — صحتك أمانة عندنا
