def log(message):
    with open("logs/error.log", "a") as f:
        f.write(message + "\n")

log("Test log from feature branch")
