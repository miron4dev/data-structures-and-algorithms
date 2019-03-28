module Algorithms::Leetcode::String
#
# Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

# Note: For the purpose of this problem, we define empty string as valid palindrome.
#
  class Palindrome

    CHAR_MAP = Array.new(256, 0) # works only for ASCII

    (0..9).each {|i| CHAR_MAP[i + '0'.ord] = 1 + i}
    (0..25).each {|i| CHAR_MAP[i + 'a'.ord] = CHAR_MAP[i + 'A'.ord] = 11 + i}

    def palindrome?(str)
      return true if str.empty?

      from = 0
      to = str.size - 1

      while from < to
        a = CHAR_MAP[str[from].ord]
        b = CHAR_MAP[str[to].ord]

        if a.zero?
          from += 1
          next
        end

        if b.zero?
          to -= 1
          next
        end

        return false if a != b

        from += 1
        to -= 1
      end

      true
    end
  end
end
