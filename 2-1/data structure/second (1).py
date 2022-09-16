def second(numbers):
    """ 두번째로 큰 수를 찾는 함수  """
    firstBig = -float('inf')
    secondBig = -float('inf')

    for number in numbers:
        if number > firstBig:
            secondBig = firstBig
            firstBig = number
        elif number > secondBig:
            secondBig = number

    return secondBig



x = [7, 4, 6, 9, 88, 99]
print(second(x))


