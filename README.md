

# Day 36 — Thread Dump & Jstack
Thread Dump có thể tạo thoải mái trên môi trường production mà không lo ảnh hưởng tới ứng dụng, khác với heap dump tạo nguyên một bộ nhớ heap bằng tới heap hiện tại của app có thể stop application từ vài giây đến vài phút, thread dump rất nhẹ và nhanh nên không làm ảnh hưởng.

## 🚀 Mục tiêu

Hướng dẫn cách tạo **Thread Dump** bằng lệnh `jstack` để phân tích trạng thái luồng của ứng dụng Java. 

---

## 🧪 Cách chạy

### 1. Chạy ứng dụng

Hãy đảm bảo ứng dụng Java của bạn đang chạy.

### 2. Lấy PID bằng `jps`

```bash
$ jps
15841 Main
22155 Jps
17486 DeadlockDemo
```

### 3. Tạo thread dump bằng `jstack`

```bash
$ jstack 17486
2025-11-16 13:51:21
Full thread dump OpenJDK 64-Bit Server VM (21.0.8+9-b1038.73 mixed mode, sharing):
...
```

---

