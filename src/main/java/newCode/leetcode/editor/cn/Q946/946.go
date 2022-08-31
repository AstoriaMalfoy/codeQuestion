package main

import "fmt"

func main() {
	result := validateStackSequences([]int{1, 2, 3, 4, 5}, []int{4, 5, 3, 2, 1})
	fmt.Println(result)
}

// leetcode submit region begin(Prohibit modification and deletion)
func validateStackSequences(pushed []int, popped []int) bool {
	// 长度不同 直接跳过
	if len(popped) != len(pushed) {
		return false
	}

	var stack []int
	leftPoint := 0
	stack = push(stack, pushed[leftPoint])
	leftPoint++
	for i := 0; i < len(popped); i++ {
		var va = -1
		for va = peek(stack); va != popped[i] && leftPoint < len(pushed); {
			stack = push(stack, pushed[leftPoint])
			leftPoint++
			va = peek(stack)
		}
		if leftPoint > len(pushed) || va != popped[i] {
			return false
		} else {
			stack, _ = pop(stack)
		}
	}
	return true
}

func push(stack []int, value int) (reStack []int) {
	return append(stack, value)
}

func pop(stack []int) (reStack []int, value int) {
	if len(stack) == 0 {
		return nil, -1
	}
	topEleme := stack[len(stack)-1]
	right := len(stack) - 1
	if right < 0 {
		right = 0
	}
	return stack[0:right], topEleme
}

func peek(stack []int) (value int) {
	if len(stack) == 0 {
		return -1
	}
	return stack[len(stack)-1]
}

//leetcode submit region end(Prohibit modification and deletion)
