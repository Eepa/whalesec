# Instructions for HTTP Response Splitting testing

1. Find vulnerable target
    - See instructions: TODO
2. Create payload
   - You can encode the payload with iconv
   ```
   echo '<script>alert("XSS");</script>' | iconv -f utf-8 -t utf-7
   

   # Output
   +ADw-script+AD4-alert(+ACI-XSS+ACI)+ADsAPA-/script+AD4
   
   ```
3. 
4. 

```
echo '+ADw-script+AD4-alert(+ACI-XSS+ACI)+ADsAPA-/script+AD4' | iconv -f utf-7 -t utf-8

<script>alert("XSS");</script>
```





































































