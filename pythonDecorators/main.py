def log(block):
    def wrapper(*args, **kwargs):
        print(f"Executing {block.__name__} with args: {args}, kwargs: {kwargs}")
        result = block(*args, **kwargs)
        print(f"{block.__name__} returned: {result}")
        return result
    return wrapper
