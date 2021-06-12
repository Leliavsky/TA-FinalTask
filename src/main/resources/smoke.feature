Feature: Smoke
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario: Check add product to Saved Items
    Given User opens 'https://www.asos.com/' page
    And User clicks to men clothes
    And User clicks to Shoes & Trainers
    When User add any product to Saved Items
    And User go to Saved Items
    Then User check his Saved List

    Scenario Outline: Check search line work correctly
      Given User opens '<homePage>' page
      When User makes search by keyword '<keyword>'
      And User clicks search button
      Then User checks search field visibility
      Examples:
        | homePage              | keyword|
        | https://www.asos.com/ | nike   |
        | https://www.asos.com/ | adidas |
        | https://www.asos.com/ | reebok |

  Scenario Outline: Check switch language work correctly
    Given User opens '<homePage>' page
    And User clicks on language button
    When User clicks on drop-out window
    And User clicks on Ukraine language
    And User click on update preference
    Then User check website update preference

    Examples:
      | homePage              |
      | https://www.asos.com/ |

    Scenario Outline: Check Account massage if write not correct email
      Given User opens '<homePage>' page
      And User clicks on Account button
      When User introduces incorrect email '<keyword>'
      And User clicks on Sigh In button
      Then User checks that not correct email popup visible
      Examples:
        | homePage              | keyword  |
        | https://www.asos.com/ | Morogenoe|

      Scenario Outline: Check add to bag item without size
        Given User opens '<homePage>' page
        When User makes search by keyword '<keyword>'
        And User clicks search button
        And User clicks on item
        And User click on button add to bag
        Then User checks popup window with select size visible
        Examples:
          | homePage              | keyword  |
          | https://www.asos.com/ | reebok   |

        Scenario Outline: Check add to bag item
          Given User opens '<homePage>' page
          When User makes search by keyword '<keyword>'
          And User clicks search button
          And User clicks on item
          And User click on size popup window
          And User clicks to take a size
          And User click on button add to bag
          Then User check his bag

          Examples:
            | homePage              | keyword  |
            | https://www.asos.com/ | reebok   |

          Scenario Outline: Check search line to put extra words, more than 150
            Given User opens '<homePage>' page
            When User makes search by keyword '<keyword>'
            And User clicks search button
            Then User check search line on extra words

            Examples:
              | homePage              | keyword |
              | https://www.asos.com/ | reebokfesklfsdk;fjldskfdsklfsd          dsfjdslfdlsfjsdlfj         dkfklsdjflsdjflds               dskfsldfjljsd  12323323 After that text did not fit ---> sdfsdfds 2343243423423 |

            Scenario Outline: Check after searching all visible elements
              Given User opens '<homePage>' page
              When User makes search by keyword '<keyword>'
              And User clicks search button
              Then User check number of search items

              Examples:
                | homePage              | keyword  |
                | https://www.asos.com/ | reebok   |

              Scenario Outline: Check Account sigh in work correct
                Given User opens '<homePage>' page
                And User clicks on Account button
                When User introduces correct email '<keyword>'
                And User write password '<password>'
                And User clicks on Sigh In button
                Then User check his logged in

                Examples:
                  | homePage              | keyword                   | password |
                  | https://www.asos.com/ | testertestoletka@gmail.com|Test123456|

                Scenario Outline: Check information in Help & FAQs
                  Given User opens '<homePage>' page
                  And User clicks on FQAs button
                  When User check search helping line
                  Then User check six topics FAQs

                  Examples:
                    | homePage              |
                    | https://www.asos.com/ |