# Same-origin policy examples

Based on: https://www.youtube.com/watch?v=zul8TtVS-64

## Site with same origin
```

# In a browser open: http://whaleback.test.local:90/whale

# Open developer tools console

# Open new window in browser from the console 
$ var newwhale = window.open('http://whaleback.test.local:90/whale', 'whale2')

# Check the body of the new window
$ newwhale.document.body

# Update the inner text of whale2 page body
$ newwhale.document.body.innerText = "I see whales!"

# You see that the body content changed

```

## Site with different origin
```

# In a browser open: http://whaleback.test.local:90/whale

# Open developer tools console

# Open new window in browser from the console 
$ var newcat = window.open('http://catback.test.mau:91/cat', 'cat2')

# Check the body of the new window
$ newcat.document.body

# Update the inner text of cat2 page body
$ newcat.document.body.innerText = "I see cats!"

# You see that you cannot access the body or update the text on a page on a different origin
# SOP is protecting the pages on browser against this

```

## Site with different origin and opener link
```

# In a browser open: http://whaleback.test.local:90/whale

# Open developer tools console

# Open new window in browser from the console 
$ var newcat = window.open('http://catback.test.mau:91/cat', 'cat2')

# Move to the opened cat2 window and try to check the opener and its body
$ window.opener
$ window.opener.document.body

# SOP prevents you to see the body

# Update the location of the opener from the cat2 window
$ window.opener.location.replace("http://google.com")

# You see that the location of the original page was switched to the new location which was specified

```