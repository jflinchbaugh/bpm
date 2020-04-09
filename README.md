# BPM

A quick little BPM counter from tapping on a button.

### Development mode

The app was initialized from the `reagent-frontend` template:
```
lein new reagent-frontend bpm-web
```

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.

### REPL

The project is setup to start nREPL on port `7002` once Figwheel starts.
Once you connect to the nREPL, run `(cljs)` to switch to the ClojureScript REPL.

### Emacs CIDER

To work on the project in emacs, start up emacs, jack into cljs, choose `figwheel` when prompted,
and it'll start up the server from emacs. Navigate to the http://loalhost:3449/ to browse the app.

### Building for Production

```
lein package
```

### Deploying Production Artifacts

Copy `public/js/app.js`, `public/index.html`, and `public/css/site.css` to a static site.
